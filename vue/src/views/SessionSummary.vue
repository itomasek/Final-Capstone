<template>
  <div>
    <div>
      <router-link
        v-bind:to="{
          name: 'my-decks',
          params: { user_id: this.$store.state.user.id },
        }"
        ><button>Start A New Study Session</button></router-link
      >
    </div>
    <h4>Your Study Session History</h4>
    <table class="history-table">
      <thead>
        <tr>
          <td>Deck Studied</td>
          <td>Total Cards</td>
          <td>Correct</td>
          <td>Incorrect</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="session in sessions" v-bind:key="session.sessionId">
          <td>{{ session.deckStudied }}</td>
          <td>{{ session.totalCards }}</td>
          <td>{{ session.totalCorrect }}</td>
          <td>{{ session.totalIncorrect }}</td>
        </tr>
      </tbody>
    </table>
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
};
</script>

<style>
    
</style>