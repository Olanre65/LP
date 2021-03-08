import React from 'react';
import ListProductsComponent from './ListProduct';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ProductComponent from './ProductComponent';

class InstructorApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h1>Instructor Application</h1>
                    <Switch>
                        <Route path="/" exact component={ListProductsComponent} />
                        <Route path="/courses" exact component={ListProductsComponent} />
                        <Route path="/courses/:id" component={ProductComponent} />
                    </Switch>
                </>
            </Router>
        )
    }
}