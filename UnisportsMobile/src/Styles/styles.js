import { StyleSheet } from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
    flexDirection: 'column'
  },
  settingsContainer: {
    flex: 1,
    alignItems: 'center',
    backgroundColor: 'white',
    flexDirection: 'column'
  },
  employeeLogo: {
    width: 65,
    height: 65,
    marginLeft: 10
  },
  ListView: {
    flex: 1,
    overflow: 'hidden',
    backgroundColor: '#E5E5E5',
    alignSelf: 'stretch'
  },
  row_container: {
    backgroundColor: '#FFFFFF',
    paddingHorizontal: 20,
    paddingVertical: 10,
    marginVertical: 6,
    marginHorizontal: 12,
    flexDirection: 'column',
    borderRadius: 2,
    elevation: 1
  },
  textCardMainTitle: {
    fontSize: 20,
    textAlignVertical: 'center',
  },
  textCardTitle: {
    fontSize: 15,
  },
  labelCardMainTitle: {
    fontWeight: 'bold',
    fontSize: 20,
    textAlignVertical: 'center',
    minHeight: 30
  },
  labelCardTitle: {
    fontWeight: 'bold',
    fontSize: 15,
  },
  alignRight: {
    alignContent: 'flex-end',
  },
  searchBox: {
    backgroundColor: '#fb8c00',
    alignSelf: 'stretch',
    paddingVertical: 10,
    elevation: 2
  },
  singleLine: {
    marginHorizontal: 10,
    fontSize: 16,
    padding: 4,
    color: '#fff'
  },
  employerDetailsCollapseTitle: {
    alignSelf: 'stretch',
    backgroundColor: 'yellow',
    paddingVertical: 10,
    paddingHorizontal: 10,
    elevation: 2,
    borderBottomColor: 'gray',
    borderBottomWidth: 1
  },
  employerDetailsContent: {
    alignSelf: 'stretch',
    backgroundColor: '#fb8c00',
    paddingVertical: 10,
    paddingHorizontal: 10,
    elevation: 2
  },
  employerDetailsTasks: {
    alignSelf: 'stretch',
    backgroundColor: '#FFA726',
    paddingVertical: 10,
    paddingHorizontal: 10,
    elevation: 2
  },
  employerDetailsName: {
    fontSize: 22,
    color: '#fff'
  },
  employerDetailsLabel: {
    fontSize: 15,
    fontWeight: 'bold',
    color: '#fff'
  },
  employerDetailsText: {
    fontSize: 15,
    color: '#fff'
  },
  employerDetailsTextSmall: {
    fontSize: 12,
    color: '#fff'
  },
  box1: {
    flex:1,
  },
  detailBox: {
    flexDirection: 'row'
  },
  loadingContainer: {
    flex:1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'red',
    position: 'absolute',
    zIndex: 1000
  },
  loadingModalContainer: {
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
    backgroundColor: 'rgba(0, 0, 0, 0.5)'
  },
  loadingModalContent: {
    backgroundColor: '#fff', 
    padding: 20, 
    borderRadius: 10, 
    alignItems: 'center', 
    justifyContent: 'center', 
    height: 150, 
    width: 150 
  },
  informativeSearchText: {
    fontSize: 20,
    backgroundColor:'#E5E5E5',
    alignSelf: 'stretch',
    textAlign:'center'
  },
  settingsTitleContent: {
    alignSelf: 'stretch',
    paddingHorizontal: 30,
    paddingTop: 25,
    paddingBottom: 10
  },
  settingsTitle: {
    fontSize: 18,
    color: '#000'
  },
  settingsOptionButton: {
    alignSelf: 'stretch'
  },
  settingsOptionContent: {
    alignSelf: 'stretch',
    paddingHorizontal: 30,
    paddingVertical: 10
  },
  settingsOptionText: {
    fontSize: 14,
    color: '#000'
  },
  taskNotification: {
    height: 20,
    width: 20,
    position: 'absolute',
    zIndex: 1000,
    top: 10,
    right: 10,
    borderRadius: 10
  }
});

module.exports = styles;