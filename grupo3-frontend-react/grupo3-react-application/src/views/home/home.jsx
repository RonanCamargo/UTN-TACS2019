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

		}
	}

	render() {
		return (
			<div className="home-container">
				<div className="header-options">
					<h2 className="title-header"> Bienvenido </h2>
					<Button variant="outline-dark" className="log-out" onClick={this.props.logoutUser}><b>Log out</b></Button>
				</div>
				<Button className="home-options" variant="primary" size="lg" onClick={() => {this.props.history.push('/login')}} block>
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
		)
	}
}

export default withRouter(Home)
