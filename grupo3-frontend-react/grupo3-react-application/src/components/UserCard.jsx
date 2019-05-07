import React, {Component} from 'react';

class UserCard extends Component
{
	constructor () {
	    super()
	    this.state = {
	      isHidden: true
	    }
	  }

	  toggleHidden () {
	    this.setState({
	      isHidden: !this.state.isHidden
	    })
	  }

  render()
  {
    return(
        <div className = "col-md-4" >
          <div className = "card mt-4"
						  onMouseEnter={this.toggleHidden.bind(this)}
							onMouseLeave={this.toggleHidden.bind(this)}>

					    <div className = "card-header" className="listCardHeader">

                  <a target="_blank" href={ this.props.url } >
                <img src={ this.props.url } alt="Cinque Terre" width="300" height="auto" className="thumb">
                  </img>
                </a>
                {!this.state.isHidden && <div className = "extraInfo">	<p> Number of lists: <mark><strong> { this.props.lists }</strong> </mark></p>
                                  <p> Places visited: <mark><strong> { this.props.visits }</strong> </mark></p>
                                  <p> Last access: <mark><strong> { this.props.lastAccess }</strong></mark> </p>

                                  <div className="input-group">
                                      <select className="form-control" id="selectList" placeholder= "select a List">
                                          <option>favs</option>
                                       </select>
                                      <span className="input-group-btn">
                                      <button type="submit" className="btn btn-warning">Compare</button>
                                      </span>
                                  </div>
                </div>}
					    </div>
					    <div className = "card-body" className="listCardBody">
              <p>{ this.props.cardName }</p>
					    </div>
          </div>
        </div>
  		);
  }
}

export default UserCard;
