import React  from 'react';
import { Text, View } from 'react-native';

import GetApi from '../../components/GetApi'

const TopRatedScreen = ({navigation}) => {
    
        return (
            <View style={{ flex: 1,alignItems: 'center' }}>
                <GetApi type = '/movie/top_rated' navigation={navigation}/>
            </View>
        )
    
}
export default TopRatedScreen;