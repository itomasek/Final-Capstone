<template>
  
  <div class="container">
    <img class="hero-img" src="../../assets/Logo.jpg" alt="placeholder-logo">
    <div>
      <router-link v-bind:to="{ name: 'home' }"
        ><button class="header">Home</button></router-link
      >
    </div>
    
    <div>
      <router-link v-bind:to="{ name: 'register' }"
        ><button class="header">Register</button></router-link
      >
    </div>
    <div><button class="header">Info</button></div>

    <div v-if="$store.state.token != ''">
      <router-link v-bind:to="{ name: 'logout' }"
        ><button class="header">Logout</button></router-link
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "app-header",
};
</script>

<style>
.container {
  display: flex;
  align-items: center;
  flex-wrap: nowrap;
  background: #CDDEE8;
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
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  padding: 20px;
  background-color: #DEEBF3;
}

.header:hover {
  text-decoration: underline;
}



</style>