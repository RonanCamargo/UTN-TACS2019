import React, { Component } from "react"
import { Route, Redirect, Switch, withRouter } from "react-router-dom"
import {Button, Card} from "react-bootstrap"

class Place extends Component {
	constructor(props) {
		super(props)
		this.state = {
			place:{
				title: '',
				subTitle: '',
				description: '',
			}
		}
		this.addPlace = this.addPlace.bind(this)
	}

	addPlace() {
		const place = {
			id : this.props.id,
			title : this.props.title,
			subTitle : this.props.subTitle,
			description : this.props.description,
		}
		this.props.addPlaceToList(place)
	}

	render() {
		return (
			<div>
				<Card style={{ width: '18rem' }}>
					<Card.Body>
						<Card.Title>{this.props.title}</Card.Title>
						<Card.Subtitle className="mb-2 text-muted">{this.props.subTitle}</Card.Subtitle>
						<Card.Text>
							{this.props.description}
						</Card.Text>
						<Button variant="primary" onClick={this.addPlace}>Add</Button>
					</Card.Body>
				</Card>
			</div>
		)
	}
}

export default withRouter(Place)
