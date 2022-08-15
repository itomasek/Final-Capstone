<template>
  <div class="entire-page">
    <div class="session-summary">
      <router-link
        v-bind:to="{
          name: 'my-decks',
          params: { user_id: this.$store.state.user.id },
        }"
        ><button id="nsbutton">Start A New Study Session</button></router-link
      >
    </div>
    <h3 id="history">Your Study Session History</h3>
    
    <table class="history-table">
      <thead>
        <tr id="headings">
          <td>Deck Studied</td>
          <br>
          <td>Total Cards</td>
          <br>
          <td>Correct</td>
          <br>
          <td>Incorrect</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="session in sessions" v-bind:key="session.sessionId">
          <td>{{ session.deckStudied }}</td>
          <br>
          <td>{{ session.totalCards }}</td>
          <br>
          <td>{{ session.totalCorrect }}</td>
          <br>
          <td>{{ session.totalIncorrect }}</td>
        </tr>
      </tbody>
    </table>
    <div class="clear-container">
     <button id="clearbutton" v-on:click="clearSession">Clear Session History</button>
     </div>
  </div>
</template>

<script>
import CardService from "../services/CardService";
export default {
  name: "session-summary",
  data() {
    return {
      sessions: [],
    };
  },
  created() {
    CardService.getSessions(this.$store.state.user.id).then((response) => {
      this.sessions = response.data;
    });
  },
  updated(){
    CardService.getSessions(this.$store.state.user.id).then((response) => {
      this.sessions = response.data;
    });
  },
  methods:{
    clearSession(){
      CardService.clearSessions(this.$store.state.user.id);

    }
  }
};
</script>

<style>
.entire-page{
  width: 100vw;
  height: 100vh;
  
}
    
  #history{
    font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
    text-align: center;
  }
  .session-summary{
    display: flex;
    font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
    justify-content: space-around;
    margin: auto;
  }
  #headings{
    text-decoration: underline;
  }
  .history-table{
    align-content:center;
    text-align: center;
    font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
    margin: auto;
    
    
  }
  #nsbutton{
    border-radius: 10px;
    width: 150px;
    height: 50px;
    margin-top:10px;
  }
  .clear-container{
    display: flex;
    justify-content:center;
    margin-top: 10px;
  }
  #clearbutton{
    text-align:center;
    border-radius: 10px;
    width: 150px;
    height: 50px;
    margin-top:10px;
    
  }
</style>