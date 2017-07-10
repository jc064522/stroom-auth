import React from 'react'
import PropTypes, {object} from 'prop-types'
import queryString from 'query-string'

import { Button, Card, Input, Row, Col } from 'react-materialize'

import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import reactReferer from 'react-referer'

import {attempLogin} from '../../modules/login'

import './Login.css'

class Login extends React.Component {

  constructor(props, context) {
    super(props, context)
    this.state = {
      username: '',
      password: '',
      // Try and get the referrer, or if there isn't one use '/'. E.g. one might use the following to set the referrer.
      // <Redirect to={{
      //    pathname: '/login',
      //    state: {referrer:'/user'}}}/>
      referrer: this.context.router.history.location.state !== undefined ? this.context.router.history.location.state.referrer : ''
    }
  }

  login(username, password) {
    this.props.attempLogin(this.state.username, this.state.password, this.state.referrer)
  }      

  render() {
    return(
      <Row>
          <Col s={4} />
          <Col s={4}>
            <div>
              <form>
                <Card title='Please log in' actions={[
                  <Button key="submitButton" type="button" waves='light' className="Login-button" 
                    onClick={ () => this.login(this.props.username, this.props.password)} 
                    onSubmit={ () => this.login(this.props.username, this.props.password)}>
                      Log in
                  </Button>
                ]}>
                  <Row>
                   <Input label="Username" s={12} 
                      value={this.state.username} onChange={ (e) => this.setState({username: e.target.value})}/>
                  </Row>
                  <Row>
                    <Input type="password" label="Password" s={12} 
                      value={this.state.password} onChange={ (e) => this.setState({password: e.target.value})}/>
                  </Row>
                </Card>
              </form>
            </div>
             </Col>
          <Col s={1} />
      </Row>
    )
  }
}

Login.contextTypes = {
  router: PropTypes.shape({
    history: object.isRequired,
  }),
};

const mapStateToProps = state => ({
})

const mapDispatchToProps = dispatch => bindActionCreators({
  attempLogin,
}, dispatch)

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Login)