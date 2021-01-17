import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import DetailsScreen from '../../containers/DetailsScreen';

const Stack = createStackNavigator();

import UpcomingMoviesScreen from '../../containers/UpcomingMoviesScreen';


const UpcomingMoviesNav = () => {
    return (
         
       <Stack.Navigator headerMode= "none" >
         <Stack.Screen name="Home" component={UpcomingMoviesScreen} />
        <Stack.Screen name="Details" component={DetailsScreen} />
       </Stack.Navigator>

    );
}

export default UpcomingMoviesNav;