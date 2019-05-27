import React, { Component } from "react"
import Navigation from 'components/Navigation'
import PlaceCard from 'components/PlaceCard'
import { geolocated } from 'react-geolocated'
import axios from 'axios'

class PlaceView extends Component {
	initDashboard() {
		const location = this.props.coords.latitude + ',' + this.props.coords.longitude
		axios.get('http://localhost:8080/places/near?coordinates=' + location, {
			headers: {
				Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKUGVyZXoxIiwiUk9MIjoiQURNSU4ifQ.3I3laL6doeyt7iSf_Ew_dHAKqIHSeHFE5SmfwwkDh0Gx-1qhBY9GmT11iz8KS3_dEvOlBzn8uM2t4f2ZGxHYbQ'
			},
		})
	    .then(response =>
			this.setState({places : response.data})
	    )
		.catch(err => {
			console.log(err);
		})
    }

	render() {
		if(this.props.coords) {
			this.initDashboard()
		}
		const places = this.state.places.map(place => {
			return(
				<PlaceCard key={place.id} cardName = {place.name} id = {place.id} url = {place.location.address} image = "w3-grayscale-max" />
			)
		})
		return (
			<div className="main-container">
				<Navigation title= "Home" />
				<div className= "container">
					<div className= "row mt-4">
						<div className="row active-with-click">
							{places}
						</div>
					</div>
				</div>
			</div>
		)
	}
}

export default geolocated({
	positionOptions: {
		enableHighAccuracy: false,
	},
	userDecisionTimeout: 5000,
})(PlaceView)
