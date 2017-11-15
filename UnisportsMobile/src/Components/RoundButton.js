import React, { Component } from 'react';
import {
    AppRegistry,
    Text,
    View,
    TouchableHighlight
} from 'react-native';
import styles from '../Styles/styles'

class RoundButton extends React.Component {
    render() {
        return (
            <TouchableHighlight underlayColor='rgba(0,0,0,0)' style={[this.props.style, { paddingBottom: 2 }]} onPress={() => { this.props.onPressButton() }}>
                <View style={{ backgroundColor: this.props.bgColor, height: this.props.size, width: this.props.size, alignItems: 'center', 
                    borderRadius: (this.props.size/2), marginHorizontal: 10, justifyContent: 'center', elevation: 2 }}>
                    { this.props.children }
                </View>
            </TouchableHighlight>
        );
    }
}

module.exports = RoundButton;