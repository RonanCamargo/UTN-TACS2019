import React, { Component } from "react";
import axios from 'axios';
import Navigation from 'components/Navigation';
import UserCard from 'components/UserCard';

class UserView extends Component {
    constructor() {
        super();
        this.state = {
          users: [
                  { "id": "1",
                    "name": "Celeste Sanchez",
                    "lists": "3",
                    "visits": "12",
                    "lastAccess": "06-04-19",
                    "url": "https://i.pinimg.com/564x/92/e6/24/92e624d8392f7ae612c107b3c487919c.jpg"
                  }
                  ,
                  { "id": "2",
                    "name": "Mercedes Alonso",
                    "lists": "4",
                    "visits": "7",
                    "lastAccess": "06-04-19",
                    "url": "https://i.pinimg.com/236x/22/d9/3c/22d93c3950b0feb81c2142ec74fbef89.jpg"
                  }
                  ,
                  { "id": "3",
                    "name": "Mariana Gramajo",
                    "lists": "7",
                    "visits": "24",
                    "lastAccess": "26-04-19",
                    "url": "https://i.pinimg.com/236x/4f/f1/62/4ff162a314ccdcc6976e284a2e5aa1ac.jpg"
                  },
                  { "id": "4",
                    "name": "Marina Zerbarini",
                    "lists": "2",
                    "visits": "12",
                    "lastAccess": "05-04-19",
                    "url": "https://i.pinimg.com/564x/9b/d7/64/9bd764e8f3004b4a7236db5b16e394c9.jpg"
                  }
                  ,
                  { "id": "5",
                    "name": "Antonella Paoletti",
                    "lists": "5",
                    "visits": "12",
                    "lastAccess": "06-02-19",
                    "url": "https://i.pinimg.com/564x/41/97/f5/4197f5ae530692d5f204c9a123d85b25.jpg"
                  }
                  ,
                  { "id": "6",
                    "name": "Ciro Museres",
                    "lists": "1",
                    "visits": "11",
                    "lastAccess": "16-01-19",
                    "url": "https://i.pinimg.com/564x/0e/0f/06/0e0f06d1cfecb08d97645c7751e91a8c.jpg"
                  }
                ]
               };
    }

    componentDidMount() {
      axios.get('http://localhost:8080/places', {withCredentials: true})
        .then(json => this.setState({ places: json }))
    }

    render() {
        const users = this.state.users.map(user => {
        return(
          <UserCard key={user.id} cardName = {user.name} lists = {user.lists} visits = {user.visits} lastAccess = {user.lastAccess} url = {user.url} />
        )
        })
        return (
          <div className="main-container">
            <Navigation title= "Home" />
            <div className= "helper">
              <div className= "row mt-4">
                <p><strong>Borrar todo esto.</strong></p>
                  <p>View solo para admins.</p>
                  <p>Modificar style de card user.</p>
                  <p>Ver de unificar con stats.</p>
                  <p>Agregar select o nav para elegir consultar places o users.</p>
                  <p>El boton compare debe permitir seleccionar un user y mostrarlo en un div con user name y list seleccionada</p>
                  <p>Si tengo dos users seleccionados los muestro juntos y me podra decir los lugares comunes</p>
              </div>
            </div>
            <div className= "container">
                <div className= "row mt-4">
                  <div className="row active-with-click">
                    {users}
                   </div>
               </div>
            </div>
          </div>
        );
    }
}

export default UserView;
