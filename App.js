import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { Scene, Router } from 'react-native-router-flux';

import { SCREEN_DEVICE, SCREEN_MODE, SCREEN_DRIVING, SCREEN_RELAY } from './src/screens/';

class App extends React.Component {
  render() {
    return (
      <Router>
        <Scene key="root">
          <Scene key="SCREEN_MODE" component={SCREEN_MODE} title="MODE" initial={true} />
          <Scene key="SCREEN_DEVICE" component={SCREEN_DEVICE} title="DEVICE" />
          <Scene key="SCREEN_DRIVING" component={SCREEN_DRIVING} title="DRIVING" />
          <Scene key="SCREEN_RELAY" component={SCREEN_RELAY} title="RELAY" />
        </Scene>
      </Router>
    )
  }
};

// const styles = StyleSheet.create({
//   scrollView: {
//     backgroundColor: Colors.lighter,
//   },
// });

export default App;
