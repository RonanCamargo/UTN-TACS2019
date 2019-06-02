import React, { Component } from "react"
import { Route, Redirect, Switch, withRouter } from "react-router-dom"
import LogInUser from "views/login/user/login_user"
import SignUp from "views/signup/user/signup_user"
import PlaceView from "views/place/PlaceView"
import ListView from "views/place/ListView"
import AdminView from "views/admin/AdminView"
import UserView from "views/admin/UserView"

class App extends Component {
	constructor(props) {
		super(props)
		this.state = {
			userLogged : false,
			token: '',
			user : {
				firstName : '',
				lastName : '',
				userName : '',
				password : '',
			},
		}
		this.updateProps = this.updateProps.bind(this)
		this.updateState = this.updateState(this)
	}

	updateProps(key, value) {
		this.setState({
			user:{
				...this.state.user,
				[key]:value
			}
		})
	}

	updateState(key, value) {
		this.setState({
			[key]:value
		})
	}
	render() {
		if (!window.userLogged) {
			<Redirect to="/login" />
		}
		return (
			<div>
				<Switch>
					<Route path={"/login"}
					       component={() =>
								<LogInUser updateProps={this.updateProps}
								           updateState={this.updateState}
								           history={this.props.history} />
					       }
					/>
					<Route path={"/signup"}
					       component={() =>
							<SignUp updateProps={this.updateProps}
									history={this.props.history}/>}
					/>
					<Route path={"/places"} component={PlaceView} />
					<Route path={"/users/list-of-places"} component={ListView} />
					<Route path={"/users"} component={UserView} />
					<Route path={"/stats"} component={AdminView} />
				</Switch>
			</div>
		)
	}
}

export default withRouter(App)
