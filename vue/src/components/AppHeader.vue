<template>
  <div class="container">
    <router-link v-bind:to="{ name: 'home' }">
      <img
        class="hero-img"
        src="../../assets/Logo.jpg"
        alt="placeholder-logo"
      />
    </router-link>

    <div v-if="$store.state.token != ''">
      <router-link v-bind:to="{ name: 'new-card' }"
        ><button class="header">Create New Card</button></router-link
      >
    </div>
    <div v-if="$store.state.token != ''">
      <router-link v-bind:to="{ name: 'new-deck' }"
        ><button class="header">Create New Deck</button></router-link
      >
    </div>
    <div v-if="$store.state.token != ''">
      <router-link
        v-bind:to="{
          name: 'my-cards',
          params: { user_id: this.$store.state.user.id },
        }"
      >
        <button class="header">Your Cards</button>
      </router-link>
    </div>
    <div v-if="$store.state.token != ''">
      <router-link
        v-bind:to="{
          name: 'my-decks',
          params: { user_id: this.$store.state.user.id },
        }"
        ><button class="header">Your Decks</button></router-link
      >
    </div>
    <div v-if="$store.state.token != ''">
      <button class="header" v-on:click="doStudy">Study Session</button>
    </div>
    <div class="rlbuttons">
      <div v-if="$store.state.token == ''">
        <router-link v-bind:to="{ name: 'register' }"
          ><button class="register">Register</button></router-link
        >
      </div>

      <div id="logout-button" v-if="$store.state.token != ''">
        <router-link v-bind:to="{ name: 'logout' }"
          ><button class="header">Logout</button></router-link
        >
      </div>
      <div id="login" v-else>
        <router-link v-bind:to="{ name: 'login' }">
          <button id="login-button">Login</button></router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "app-header",
  methods: {
    doStudy() {
      this.$router.push({
        name: "my-decks",
        params: { user_id: this.$store.state.user.id },
      });
    },
  },
};
</script>

<style>
.container {
  display: flex;
  align-items: center;
  justify-content: left;
  flex-wrap: nowrap;
  background: #cddee8;
  padding-left: 5px;
  padding-top: 5px;
  padding-bottom: 0;
}

.hero-img {
  height: 200px;
  width: 200px;
  margin-right: 100px;
}

.header {
  flex-grow: 1;
  justify-content: space-evenly;
  flex-grow: 1;
  margin: 25px;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  padding: 20px;
  background-color: #deebf3;
  border-radius: 10px;
  font-size: 20px;
  font-weight: bold;
}

.header:hover {
  text-decoration: underline;
}
#logout-button {
  margin-left: 100px;
}
#login-button {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  padding: 20px;
  background-color: #deebf3;
  border-radius: 10px;
  font-size: 20px;
  font-weight: bold;
  margin-left: 15px;
  width: 125px;
}
#rlbuttons {
  display: flex;
}
.register {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  padding: 20px;
  background-color: #deebf3;
  border-radius: 10px;
  font-size: 20px;
  font-weight: bold;
  margin-left: 15px;
  margin-bottom: 30px;
  width: 125px;
}
</style>