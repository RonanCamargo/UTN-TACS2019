import React from 'react'
import { render } from 'react-dom'
import history from 'helpers/history'
import {
    Router as Router,
} from 'react-router-dom'
import './index.css';
import App from 'views/app'

render(
    <div>
        <Router history={history}>
            <App/>
        </Router>
    </div>,
    document.getElementById('app')
);
