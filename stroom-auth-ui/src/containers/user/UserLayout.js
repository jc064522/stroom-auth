/*
 * Copyright 2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import React, {Component} from 'react'
import { connect } from 'react-redux'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { NavLink } from 'react-router-dom'

import RaisedButton from 'material-ui/RaisedButton'
import FlatButton from 'material-ui/FlatButton'
import IconButton from 'material-ui/IconButton'
import Snackbar from 'material-ui/Snackbar'
import Toggle from 'material-ui/Toggle'
import Dialog from 'material-ui/Dialog'
import { blue600, amber900, fullWhite } from 'material-ui/styles/colors'
import Paper from 'material-ui/Card'
import { Toolbar, ToolbarGroup, ToolbarTitle } from 'material-ui/Toolbar'
import Add from 'material-ui-icons/Add'
import Delete from 'material-ui-icons/Delete'
import Edit from 'material-ui-icons/Edit'
import Help from 'material-ui-icons/Help'
import KeyboardArrowRight from 'material-ui-icons/KeyboardArrowRight'

import UserSearch from '../userSearch'
import UserCreate from '../createUser'
import UserEdit from '../editUser'
import { deleteSelectedUser, toggleAlertVisibility } from '../../modules/user'

import '../../styles/index.css'
import '../../styles/toolbar-small.css'
import '../../styles/toggle-small.css'

class UserLayout extends Component {
  constructor () {
    super()
    this.state = {
      isFilteringEnabled: false,
      isHelpDialogOpen: false
    }
  }

  deleteSelectedUser () {
    this.context.store.dispatch(deleteSelectedUser())
  }

  toggleFiltering (isFilteringEnabled) {
    this.setState({isFilteringEnabled})
  }

  handleHelpDialogOpen () {
    this.setState({isHelpDialogOpen: true})
  };

  handleHelpDialogClose () {
    this.setState({isHelpDialogOpen: false})
  };

  render () {
    const { show, selectedUserRowId, showAlert, alertText, toggleAlertVisibility } = this.props
    const showSearch = show === 'search'
    const showCreate = show === 'create'
    const showEdit = show === 'edit'
    const showCreateButton = showSearch
    const deleteButtonDisabled = !selectedUserRowId
    return (
      <Paper className='Layout-main' zDepth={0}>
        <Toolbar className='toolbar-small'>
          <ToolbarGroup>

            <NavLink to={'/userSearch'}>
              <ToolbarTitle text='Users' className='toolbar-title-small' />
            </NavLink>

            {showCreate || showEdit ? (<KeyboardArrowRight />) : (undefined)}
            {showCreate ? (<ToolbarTitle text='Create' className='toolbar-title-small' />) : (undefined)}
            {showEdit ? (<ToolbarTitle text='Edit' className='toolbar-title-small' />) : (undefined)}
          </ToolbarGroup>
          <ToolbarGroup>

            {showSearch ? (
              <Toggle
                className='toggle-small toggle-small-low'
                label='Show filtering'
                labelPosition='right'
                onToggle={(event, isFilteringEnabled) => this.toggleFiltering(isFilteringEnabled)} />
            ) : (undefined)}

            {showCreateButton ? (
              <NavLink to={'/newUser'} >
                <RaisedButton label='Create' primary className='toolbar-button-small'
                  icon={<Add color={fullWhite} />} />
              </NavLink>
            ) : (undefined)}

            {showSearch
              ? deleteButtonDisabled ? (
                <div>
                  <RaisedButton label='View/Edit' primary className='toolbar-button-small'
                    icon={<Edit color={fullWhite} />} disabled={deleteButtonDisabled} />
                </div>
              ) : (
                <NavLink to={`/user/${selectedUserRowId}`} >
                  <RaisedButton label='View/Edit' primary className='toolbar-button-small'
                    icon={<Edit color={fullWhite} />} disabled={deleteButtonDisabled} />
                </NavLink>
              ) : (undefined)}

            {showSearch ? (
              <div>
                <RaisedButton label='Delete' primary
                  icon={<Delete color={fullWhite} />} disabled={deleteButtonDisabled}
                  onClick={() => this.deleteSelectedUser()}
                  className='toolbar-button-small' />
              </div>
            ) : (undefined)}

            <IconButton onClick={() => this.handleHelpDialogOpen()} >
              <Help color={blue600} hoverColor={amber900} />
            </IconButton>
          </ToolbarGroup>
        </Toolbar>
        <div className='User-content'>
          {showSearch ? (<UserSearch isFilteringEnabled={this.state.isFilteringEnabled} />) : (undefined)}
          {showCreate ? (<UserCreate />) : (undefined)}
          {showEdit ? (<UserEdit />) : (undefined)}
        </div>
        <Snackbar
          open={showAlert}
          message={alertText}
          autoHideDuration={4000}
          onRequestClose={() => toggleAlertVisibility()}
        />
        <Dialog
          title={<div><span><Help color={blue600} /></span> &nbsp;<span>Users</span></div>}
          actions={
            <FlatButton
              label='OK'
              primary
              onTouchTap={() => this.handleHelpDialogClose()} />}
          modal={false}
          open={this.state.isHelpDialogOpen}
          onRequestClose={() => this.handleHelpDialogClose()}>
          <p>This area is for managing user accounts.</p>
          <p>The list of users here do not include those who might have logged in using certificates or LDAP credentials.</p>
        </Dialog>
      </Paper>

    )
  }
}

UserLayout.contextTypes = {
  store: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
  show: state.user.show,
  selectedUserRowId: state.userSearch.selectedUserRowId,
  showAlert: state.user.showAlert,
  alertText: state.user.alertText
})

const mapDispatchToProps = dispatch => bindActionCreators({
  deleteSelectedUser,
  toggleAlertVisibility
}, dispatch)

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(UserLayout)
