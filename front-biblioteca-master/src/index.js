import React, { StrictMode } from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import AppRoutes from './AppRoutes';
import { Provider } from 'react-redux';
import store from './redux/store'
import { RouterProvider} from 'react-router-dom';
import './App.scss';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <Provider store={store}>
      <RouterProvider router={AppRoutes} />
  </Provider>
);

reportWebVitals();
