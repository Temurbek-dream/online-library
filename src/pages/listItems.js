import React from "react";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';
// import ListSubheader from "@material-ui/core/ListSubheader";
import DashboardIcon from "@material-ui/icons/Dashboard";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import SettingsIcon from '@material-ui/icons/Settings';
import BarChartIcon from "@material-ui/icons/BarChart";
import LayersIcon from "@material-ui/icons/Layers";
import PersonIcon from '@material-ui/icons/Person';
import { Link } from "react-router-dom";

export const mainListItems = (
  <div>
    {/* <Link to={"/book"}> */}
    <ListItem button>
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <Link to='/' style={{ textDecoration: "none", color: "black" }}>
        <ListItemText primary='Total data' />
      </Link>
    </ListItem>
    {/* </Link> */}

    <ListItem button>
      <ListItemIcon>
        <ShoppingCartIcon />
      </ListItemIcon>
      <Link
        to='/book'
        style={{ textDecoration: "none", color: "black" }}
      >
        <ListItemText primary='Books sold' />
      </Link>
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LibraryBooksIcon />
      </ListItemIcon>
      <Link
        to='/booklist'
        style={{ textDecoration: "none", color: "black" }}
      >
        <ListItemText primary='Books list' />
      </Link>
    </ListItem>
      <ListItem button>
          <ListItemIcon>
              <LibraryBooksIcon />
          </ListItemIcon>
          <Link
              to='/customerList'
              style={{ textDecoration: "none", color: "black" }}
          >
              <ListItemText primary='Customer list' />
          </Link>
      </ListItem>
    <ListItem button>
      <ListItemIcon>
        <PersonIcon />
      </ListItemIcon>
      <ListItemText primary='Users' />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <SettingsIcon />
      </ListItemIcon>
      <ListItemText primary='Setting' />
    </ListItem>
  </div>
);

// export const secondaryListItems = (
//   <div>
//     <ListSubheader inset>Saved reports</ListSubheader>
//     <ListItem button>
//       <ListItemIcon>
//         <AssignmentIcon />
//       </ListItemIcon>
//       <ListItemText primary='Current month' />
//     </ListItem>
//     <ListItem button>
//       <ListItemIcon>
//         <AssignmentIcon />
//       </ListItemIcon>
//       <ListItemText primary='Last quarter' />
//     </ListItem>
//     <ListItem button>
//       <ListItemIcon>
//         <AssignmentIcon />
//       </ListItemIcon>
//       <ListItemText primary='Year-end sale' />
//     </ListItem>
//   </div>
// );
