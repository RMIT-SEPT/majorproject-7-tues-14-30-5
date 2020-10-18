import React from 'react';
// import * as FaIcons from 'react-icons/fa';
// import * as AiIcons from 'react-icons/ai';
// import * as IoIcons from 'react-icons/io';
// import Icon from '@material-ui/core/Icon';
// import AccessAlarmIcon from '@material-ui/icons/AccessAlarm';
import AddCircleOutlineRoundedIcon from '@material-ui/icons/AddCircleOutlineRounded';
import HistoryRoundedIcon from '@material-ui/icons/HistoryRounded';
import HomeRoundedIcon from '@material-ui/icons/HomeRounded';
export const SidebarData = [
  {
    title: 'Home',
    path: '/',
    icon: <HomeRoundedIcon />,
    cName: 'nav-text'
  },
  {
    title: 'Book Service',
    path: '/booking/create',
    icon: <AddCircleOutlineRoundedIcon />,
    cName: 'nav-text'
  },
  {
    title: 'Past Bookings',
    path: '/booking/history',
    icon: <HistoryRoundedIcon />,
    cName: 'nav-text'
  }

];