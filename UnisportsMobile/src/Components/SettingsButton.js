import React, { Component } from 'react';
import {
    AppRegistry,
    Text,
    View,
    Image,
    TouchableHighlight,
} from 'react-native';
import { NavigationActions } from 'react-navigation'
import styles from '../Styles/styles'

const navigateAction = NavigationActions.navigate({
  routeName: 'Settings',
  params: {},
  action: NavigationActions.navigate({ routeName: 'Settings'})
})

class SettingsButton extends React.Component {
    constructor(props) {
        super(props);
    };

    render() {
        return (
            <TouchableHighlight underlayColor='rgba(0,0,0,0)' style={{ padding: 10 }} onPress={() => { this.props.navigation.dispatch(navigateAction) }}>
                <Image source={require('../Resources/Images/more_white_48.png')} style={{ width: 25, height: 25 }} />
            </TouchableHighlight>
        );
    }
}

module.exports = SettingsButton;