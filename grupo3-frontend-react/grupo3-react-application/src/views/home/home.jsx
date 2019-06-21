import React, { Component } from "react"
import { Button } from "react-bootstrap"
import CSSModules from "react-css-modules"
import { withRouter } from 'react-router-dom'
import axios from "axios"

import styles from "./home.css"

class Home extends Component {
	constructor(props){
		super(props)
		this.state = {
			user : {}
		}
	}

	componentDidMount() {
		const token = localStorage.getItem("token")
		if(token){
			axios.get(API +'/users/me', {
				headers: {
					Authorization: 'Bearer ' + token
				}
			})
				.then(response => {
					console.log(response)
					const user = {
						firstName: response.data.body.firstName,
						lastName: response.data.body.lastName,
						userName: response.data.body.username,
						listOfPlaces: response.data.body.listOfPlaces,
						role: response.data.body.role,
					}
					this.setState({user : user})
				})
		}
	}
	render() {
		return (
			<div className="home-container">
				<div className="header-options">
					<h2 className="title-header"> Welcome </h2>
					<Button variant="outline-dark" className="log-out" onClick={this.props.logoutUser}><b>Log out</b></Button>
				</div>
				{this.state.user.role !== "ADMIN" ?(
					<div>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/users/list-of-places')}} block>
							My Lists of Places
						</Button>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/list/new')}} block>
							Add List
						</Button>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/places')}} block>
							Near Places
						</Button>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/login')}} block>
							My Location
						</Button>
					</div>
				) :	(
					<div>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/users')}} block>
							Manage Users
						</Button>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/login')}} block>
							Amount Places Registered
						</Button>
						<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/admin/places')}} block>
							Global Places Interested
						</Button>
					</div>
				)}
			</div>
		)
	}
}

export default withRouter(Home)
