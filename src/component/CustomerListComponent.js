import React, {Component} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import CustomerDataService from "../utils/CustomerDataService";

export default class CustomerListComponent extends Component {
    constructor(props) {
        super(props);
        this.retrieveCustomers = this.retrieveCustomers.bind(this);
        this.state = {
            customers: []
        }
    }

    componentDidMount() {
        this.retrieveCustomers();
    }

    retrieveCustomers() {
        CustomerDataService.getAll()
            .then(response => {
                this.setState({
                    customers: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
         const {customers} = this.state;
        return (
            <TableContainer component={Paper}>
                <Table style={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Full name</TableCell>
                            <TableCell align="right">Email</TableCell>
                            <TableCell align="right">Phone number</TableCell>
                            <TableCell align="right">Address</TableCell>
                            <TableCell align="right">IsActive</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {customers&&customers.map(items=>(
                            <TableRow key={items.id}>
                                <TableCell component="th" scope="row">
                                    {items.fullName}
                                </TableCell>
                                <TableCell align="right">{items.email}</TableCell>
                                <TableCell align="right">{items.phoneNumber}</TableCell>
                                <TableCell align="right">{items.address}</TableCell>
                                <TableCell align="right">{items.isActive}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    }
}
