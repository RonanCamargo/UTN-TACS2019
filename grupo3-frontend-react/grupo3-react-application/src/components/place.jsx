import React, { Component } from "react"
import { Route, Redirect, Switch, withRouter } from "react-router-dom"
import { Card } from "react-bootstrap"

class Place extends Component {
	constructor(props) {
		super(props)
		this.state = {
			title: '',
			subTitle: '',
			description: '',
		}
	}

	render() {
		return (
			<Card style={{ width: '18rem' }}>
				<Card.Body>
					<Card.Title>{this.props.title}</Card.Title>
					<Card.Subtitle className="mb-2 text-muted">{this.props.subTitle}</Card.Subtitle>
					<Card.Text>
						{this.props.description}
					</Card.Text>
					<Card.Link href="#">Add</Card.Link>
					<Card.Link href="#">Remove</Card.Link>
				</Card.Body>
			</Card>
		)
	}
}

export default withRouter(Place)
