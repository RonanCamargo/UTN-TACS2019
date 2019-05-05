import React, { Component } from "react";
import http_request from 'helpers/http_request';
import Navigation from 'components/Navigation';
import Card from 'components/Card';

class PlaceView extends Component {
    constructor() {
        super();
        this.state = {
          places: [
                  { "id": "1",
                    "name": "Washington Square Park",
                    "location": "https://i.pinimg.com/564x/d7/be/ea/d7beea08f312788090240120bd929b01.jpg"
                  }
                  ,
                  { "id": "2",
                    "name": "South Park",
                    "location": "https://i.pinimg.com/564x/7a/6b/e3/7a6be38270ff81198292148236222748.jpg"
                  }
                  ,
                  { "id": "3",
                    "name": "Washington DC",
                    "location": "https://i.pinimg.com/564x/55/9e/43/559e43ef4ff55bf74be9c21e35191234.jpg"
                  },
                  { "id": "4",
                    "name": "La Noria",
                    "location": "https://i.pinimg.com/564x/ed/59/7e/ed597ee6b1bba5a37a4ec337b26ce737.jpg"
                  }
                  ,
                  { "id": "5",
                    "name": "Mexico",
                    "location": "https://i.pinimg.com/564x/13/42/36/134236aa9b5b7a6e5e400d8f5fbb34e4.jpg"
                  }
                  ,
                  { "id": "6",
                    "name": "China",
                    "location": "https://i.pinimg.com/564x/f1/1e/82/f11e82851e2390f633d2ceb15a51b021.jpg"
                  }
                ]
               };
    }

    // componentDidMount() {
    //     let value =http_request.get('http://localhost:8080/places')
    //     .withCredentials()
    //     .send()
    //     .then(json => this.setState({ places: json }))
    // }

    render() {
        const places = this.state.places.map(place => {
        return(
        <Card key={place.id} cardName = {place.name} id = {place.id} url = {place.location} />
        )
        })
        return (
        <div className="App">
        <Navigation title= "Home" />
        <div className= "container">
            <div className= "row mt-4">
            <div className="row active-with-click">
            { places}
             </div>
           </div>
        </div>
        </div>
        );
    }
}

export default PlaceView;
