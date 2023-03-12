import React from 'react';

import { Link } from 'react-router-dom';
import {Component} from "react";
import AppNavbar from "./AppNavbar";
import {Button, Container} from "reactstrap";

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="link"><Link to="/books">Books</Link></Button>
                </Container>
            </div>
        )
    }
}

export default Home;