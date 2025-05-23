import firebase from "firebase/compat/app";
import "firebase/compat/storage";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAXNyFvslqiYUestWH5mPOLR2xYnWvWrhI",
  authDomain: "sw-school-demo.firebaseapp.com",
  projectId: "sw-school-demo",
  storageBucket: "sw-school-demo.firebasestorage.app",
  messagingSenderId: "568101018091",
  appId: "1:568101018091:web:7d71a76dc13a9828e6e1ae",
  measurementId: "G-0PD0GLD34P",
};

firebase.initializeApp(firebaseConfig);
export const storage = firebase.storage();
