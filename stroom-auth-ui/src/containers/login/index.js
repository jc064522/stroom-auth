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

import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import queryString from 'query-string'

import LoginUI from './LoginUI'
import { changeRedirectUrl, changeClientIdUrl, changeSessionId } from '../../modules/login'

class Login extends Component {
  componentWillMount () {
    const queryParams = queryString.parse(this.props.location.search)
    const redirectUrl = queryParams['redirectUrl']
    const clientId = queryParams['clientId']
    const sessionId = queryParams['sessionId']
    this.context.store.dispatch(changeRedirectUrl(redirectUrl))
    this.context.store.dispatch(changeClientIdUrl(clientId))
    this.context.store.dispatch(changeSessionId(sessionId))
  }

  render () {
    const { idToken } = this.props
    return (
      <div>
        {idToken ? (
          <Redirect to={'/login'} />
        ) : (
          <LoginUI />
        )}
      </div>
    )
  }
}

Login.PropTypes = {
  token: PropTypes.string.isRequired
}

Login.contextTypes = {
  store: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
  idToken: state.authentication.idToken
})

const mapDispatchToProps = dispatch => bindActionCreators({
}, dispatch)

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Login)
