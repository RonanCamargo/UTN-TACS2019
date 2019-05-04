import React, {Component} from 'react';
import Popup from 'reactjs-popup';

class InputGroup extends Component
{
  render()
  {
    return(

          <div className = "card mb-2">
          <Popup
  				trigger={<div className = "row-md-4">
              <div className="input-group">
                  <select className="form-control" id="selectList" placeholder= "select a List">
                      <option>Visitados</option>
                   </select>
                  <span className="input-group-btn">
                  <button type="submit" className="btn btn-danger">{ this.props.label }</button>
                  </span>
              </div>
          </div>}
  				position="right top"
  				on="hover"
  				>
  						<span>
  								<div className = "row-md-4">
  										<div className="input-group">
  												<input type="text" className="form-control" placeholder="Search"></input >
  												<span className="input-group-btn">
  												<button type="submit" className="btn btn-outline-secondary"><i className="fa fa-search"></i></button>
  												</span>
  										</div>
  								</div>

  								<div className="input-group">
  										<input type="text" className="form-control" placeholder="List name"></input >
  										<span className="input-group-btn">
  										<button type="submit" className="btn btn-danger">Create</button>
  										</span>
  								</div>

  						</span>
  				</Popup>
          </div> );
  }
}

export default InputGroup;
