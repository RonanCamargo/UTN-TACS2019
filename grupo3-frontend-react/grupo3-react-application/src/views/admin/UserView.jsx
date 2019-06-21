import React, { Component } from "react"
import axios from 'axios'
import Navigation from 'components/Navigation'
import UserCard from 'components/UserCard'

class UserView extends Component {
	constructor(props) {
		super(props)
		this.state = {
			users : [],
		}
	}

	componentDidMount() {
		const token = localStorage.getItem("token")
		axios.get(API +'/users', {
		headers: {
			Authorization: 'Bearer '+ token
		}})
		.then(response =>
			this.setState({
				users : response.data.body
			})
		)
	}

	render() {
		const users = this.state.users.map(user => {
			return(
				<UserCard key={user.id} cardName = {user.name} lists = {user.lists} visits = {user.visits} lastAccess = {user.lastAccess} url = {user.url} />
			)
		})
		return (
			<div className="main-container">
				<Navigation title= "Home" history={this.props.history}/>
				<div className= "container">
					<div className= "row mt-4">
						<div className="row active-with-click">
							{users}
						</div>
					</div>
				</div>
			</div>
		)
	}
}

export default UserView
