import React, {Component} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import BookDataService from "../utils/BookDataService";


export default class BookListComponent extends Component {
    constructor(props) {
        super(props);
        this.retrieveBooks = this.retrieveBooks.bind(this);
        this.state = {
            books: []
        }
    }

    componentDidMount() {
        this.retrieveBooks();
    }

    retrieveBooks() {
        BookDataService.getAll()
            .then(response => {
                this.setState({
                    books: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
        const {books} = this.state;
        return (
            <TableContainer component={Paper}>
                <Table style={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Auther name</TableCell>
                            <TableCell align="right">Title</TableCell>
                            <TableCell align="right">Pages</TableCell>
                            <TableCell align="right">Price</TableCell>
                            <TableCell align="right">Published time</TableCell>
                            <TableCell align="right">Category</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {books && books.map(items => (
                            <TableRow key={items.id}>
                                <TableCell component="th" scope="row">{items.nameOfAuthor}</TableCell>
                                <TableCell align="right">{items.titleOfbook}</TableCell>
                                <TableCell align="right">{items.numOfPages}</TableCell>
                                <TableCell align="right">{items.price}</TableCell>
                                <TableCell align="right">{items.publishedTime}</TableCell>
                                <TableCell align="right">{items.category.categoryName}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    }
}
