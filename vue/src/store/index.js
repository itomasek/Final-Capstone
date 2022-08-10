import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    exampleCards: [
      {
        cardId: 13,
        subject: 'History',
        question: 'List in order the first five presidents of the USA.',
        tags: 'Presidents, History, Government',
        answer: 'Washington, Adams, Jefferson, Madison, Monroe',
        username: 'ExampleUser',
        userId: 2

      },
      {
        cardId: 14,
        subject: 'Language',
        question: 'How do you say "Hello" in Spanish, French, and German',
        tags: 'Languages, Culture',
        answer: 'Hola! Bonjour! Guten Tag!',
        username: 'ExampleUser',
        userId: 2
      },
      {
        cardId: 15,
        subject: 'Science',
        question: 'What are the elements that comprise water? BONUS: give the molecular structure!',
        tags: 'Chemistry, Molecules, Science',
        answer: 'Hydrogen and Oxygen: H2O',
        username: 'ExampleUser',
        userId: 2

      },
    ],
    activeEditCard: {
      cardId: null,
      subject: "",
      question: "",
      tags: "",
      answer: "",
      userId: "",
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_EDIT_CARD(state, card) {
      state.activeEditCard = card;
    }
  }
})
