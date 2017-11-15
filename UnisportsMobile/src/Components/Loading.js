import React, { Component } from 'react';
import {
    AppRegistry,
    View,
    Modal,
    Text,
    ActivityIndicator,
    Animated
} from 'react-native';
import styles from '../Styles/styles';

class Loading extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            modalOpen: this.props.visible,
            backgroundModalColor: 'rgba(0, 0, 0, 0)'
        };
    };
    componentWillReceiveProps(newProps) {
        this.setState({ modalOpen: newProps.visible })
    }
    render() {
        return (
            <View style={styles.loadingContainer}>
                <Modal
                    animationType={"slide"}
                    transparent={true}
                    visible={this.state.modalOpen}
                    onRequestClose={() => {}}>
                    <Animated.View style={styles.loadingModalContainer}>
                        <View style={styles.loadingModalContent}>
                            <ActivityIndicator style={{ alignItems: 'center', justifyContent: 'center' }} color="#fb8c00" size={60} />
                            <Text style={{ fontSize: 17 }}>Loading</Text>
                        </View>
                    </Animated.View>
                </Modal>
            </View>
        );
    }
}

module.exports = Loading;