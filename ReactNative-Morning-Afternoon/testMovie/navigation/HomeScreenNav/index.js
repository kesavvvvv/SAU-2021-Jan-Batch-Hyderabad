import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack'
import HomeScreen from '../../containers/HomeScreen'
import App from '../../App'

const Stack = createStackNavigator();

const HomeScreenNav = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator headerMode= "none">
        <Stack.Screen name="HomeScreen" component={HomeScreen} />
        <Stack.Screen name="App" component={App} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default HomeScreenNav;