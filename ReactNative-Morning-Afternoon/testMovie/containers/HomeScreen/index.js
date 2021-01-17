import React  from 'react';
import { Text, View } from 'react-native';

class HomeScreen extends React.Component {

    componentWillMount(){
        this.props.navigation.navigate('App');
    }

    render () {
        return (
            <View/>
        )
    }
}

export default HomeScreen;
// export default function HomeScreen ({navigation}) {
//     return navigation.navigate("App");
// }
