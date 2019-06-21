import React, { Component } from "react"
import { withRouter } from "react-router-dom"
import {Button, Card} from "react-bootstrap"
import axios from "axios/index";

class Place extends Component {
	constructor(props) {
		super(props)
		this.state = {
			placesInList : [],
		}
		this.getPlacesInList = this.getPlacesInList.bind(this)
	}

	componentDidMount() {
		this.getPlacesInList()
	}

	getPlacesInList() {
		const token = localStorage.getItem("token")
		axios.get(API+'/users/'+ this.props.userName +'/list-of-places', {
			headers: {
				Authorization: 'Bearer ' + token
			}
		})
		.then(response => {
			let places = response.data.body.filter(entity => entity.listName === this.props.match.params.id)
			this.setState({
				placesInList : places[0].places || []
			})
		}).catch(error => {
			console.log(error)
		})
	}

	render() {
		const places = this.state.placesInList.map(place => {
			return(
				<Place key={place.foursquareId} id={place.foursquareId} title={place.name}
				       subTitle={place.address}
				       description={"Some Desc"}
				       showAddButon={false}
				       showVisitedButton={true}
				/>
			)
		})
		return (
			<div>
				{places}
			</div>
		)
	}
}

export default withRouter(Place)
