import React, { Component } from 'react';
import {
    AppRegistry,
    Text,
    View,
    TouchableHighlight,
    Image,
    Picker
} from 'react-native';
import styles from '../Styles/styles'
import RoundButton from './RoundButton'

const Item = Picker.Item;

class HomeCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedState: this.props.Status,
            updatingState: false
        };
        this.handleDocumentsButton = this.handleDocumentsButton.bind(this);
        this.startVoiceRecorder = this.startVoiceRecorder.bind(this);
        this.stopVoiceRecorder = this.stopVoiceRecorder.bind(this);
        this.handleOnPressCard = this.handleOnPressCard.bind(this);
    };
    onValueChange(value) {
        this.props.onChangeStatus(this.props.Id, value, (function (val) {
            if (val === 1) this.setState({ selectedState: value });
        }).bind(this));
    }
    getNotificationColor(days) {
        if (days == null) {
            return { backgroundColor: "#ffffff" }
        } else {
            let hexColor;
            switch (days) {
                case 0:
                    hexColor = "#ffbf00";
                    break;
                case -1:
                    hexColor = "#9F2020";
                    break;
                case -2:
                    hexColor = "#AF2020";
                    break;
                case -3:
                    hexColor = "#BF1010";
                    break;
                case -4:
                    hexColor = "#CF1010";
                    break;
                case -5:
                    hexColor = "#DF0000";
                    break;
                case -6:
                    hexColor = "#EF0000";
                    break;
                default:
                    if (days < -6) {
                        hexColor = "#FF0000";
                    }
                    else if (days > 0) {
                        hexColor = "#FFE082";
                    }
                    else {
                        hexColor = "#FF6F00";
                    }
            }
            return { backgroundColor: hexColor }
        }
    }
    handleDocumentsButton = (id) => {
        this.props.onPressDocument(this.props.ProcessId);
    };
    startVoiceRecorder = () => {
        this.props.onStartRecord(this.props.Id);
    };
    stopVoiceRecorder = (active) => {
        this.props.onStopRecord(this.props.Id, active);
    };
    handleOnPressCard = () => {
        this.props.onPressCard(this.props.ProcessId);
    };
    render() {
        const statusType = { 0: "none", 1: "Open", 2: "Closed", 3: "Rescheduled" };
        return (
            <View style={styles.row_container}>
                <View style={[styles.taskNotification, this.getNotificationColor(this.props.Notificate)]}></View>
                <View>
                    <TouchableHighlight underlayColor='rgba(0,0,0,0)' style={{ paddingRight: 20 }} onPress={() => { this.handleOnPressCard() }}>
                        <Text><Text style={styles.labelCardMainTitle}>{this.props.Name}</Text></Text>
                    </TouchableHighlight>
                    <Text><Text style={styles.labelCardTitle}>Employer:</Text> <Text style={styles.textCardTitle}>{this.props.EmployerName}</Text></Text>
                    {this.props.EmployeeName != null ? <Text><Text style={styles.labelCardTitle}>Employee:</Text> <Text style={styles.textCardTitle}>{this.props.EmployeeName}</Text></Text> : null}
                    <Text><Text style={styles.labelCardTitle}>Created Date:</Text> <Text style={styles.textCardTitle}>{this.props.CreatedDate != null ? this.props.CreatedDate.substr(0, 10) : "---"}</Text></Text>
                    <Text><Text style={styles.labelCardTitle}>Due Date:</Text> <Text style={styles.textCardTitle}>{this.props.DueDate != null ? this.props.DueDate.substr(0, 10) : "---"}</Text></Text>
                    <Text><Text style={styles.labelCardTitle}>Status:</Text> <Text style={styles.textCardTitle}>{statusType[this.props.Status]}</Text></Text>
                    <Text><Text style={styles.labelCardTitle}>Responsable:</Text> <Text style={styles.textCardTitle}>{this.props.Responsable}</Text></Text>
                </View>
                <View style={{ marginTop: 10, justifyContent: 'center', flexDirection: 'row', padding: 1, alignItems: 'center' }}>
                    <RoundButton bgColor="#03A9F4" size={40} onPressButton={this.handleDocumentsButton}>
                        {/* <Image source={require('../Resources/Images/document_black_48.png')} style={{ width: 25, height: 25 }} /> */}
                    </RoundButton>
                    <View>
                        <Picker style={{ width: 120 }} enabled={!this.state.updatingState} selectedValue={this.state.selectedState} mode="dropdown"
                            onValueChange={this.onValueChange.bind(this)}>
                            <Item label="Open" value={1} />
                            <Item label="Closed" value={2} />
                            <Item label="Rescheduled" value={3} />
                        </Picker>
                    </View>
                </View>
            </View>
        );
    }
}

module.exports = HomeCard;