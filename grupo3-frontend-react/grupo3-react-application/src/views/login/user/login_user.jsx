import React, { Component } from "react"
import { Form, Button, FormGroup, FormControl, Alert } from "react-bootstrap"
import CSSModules from "react-css-modules"
import axios from "axios"
import styles from "./login_user.css"

class LoginUser extends Component {
	constructor(props){
		super(props)
		this.state = {
			userName : '',
			password : '',
		}
	}
	
	handleChange = event => {
		this.setState({
			[event.target.id]: event.target.value
		})
	}

	handleSubmit = event => {
		event.preventDefault()
		const user = {
			username: this.state.userName,
			password: this.state.password
		}
		try {
			axios.post("http://localhost:8080/login", user)
			.then(res => {
				this.props.updateState('userLogged', true)
				this.props.updateState('token', res.data.token)
				this.props.updateProps('userName', this.state.userName)
				this.props.history.push("/places")
			})
		} catch (error) {
			alert(error)
		}
	}

	render() {
		return (
			<div className="Login">
				<Form onSubmit={this.handleSubmit}>
					<Form.Group controlId="userName">
						<Form.Label>Username/Email</Form.Label>
						<Form.Control
							autoFocus
							type="text"
							value={this.state.userName}
							onChange={this.handleChange}
							placeholder="Enter username or email"
						/>
					</Form.Group>

					<Form.Group controlId="password">
						<Form.Label>Password</Form.Label>
						<Form.Control
							value={this.state.password}
							onChange={this.handleChange}
							type="password"
							placeholder="Password"
						/>
					</Form.Group>
					<Form.Group controlId="signup">
						<Form.Label>
							{"Don't have an account? "}
							<Alert.Link href="#" onClick={() => this.props.history.push('signup')}>
								Sign Up
							</Alert.Link>
						</Form.Label>
					</Form.Group>
					<Button
						block
						type="submit"
						variant="primary"
					>
						Login
					</Button>
				</Form>
			</div>
		)
	}
}
export default CSSModules(LoginUser, styles, { allowMultiple: true })
