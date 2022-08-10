<template>
  
  <div class="container">
    <img class="hero-img" src="../../assets/Logo.jpg" alt="placeholder-logo">
    <div>
      <router-link v-bind:to="{ name: 'home' }"
        ><button class="home">Home</button></router-link
      >
    </div>
    
    <div>
      <router-link v-bind:to="{ name: 'register' }"
        ><button class="register">Register</button></router-link
      >
    </div>
    <div><button class="info">Info</button></div>

    <div v-if="$store.state.token != ''">
      <router-link v-bind:to="{ name: 'logout' }"
        ><button class="logout">Logout</button></router-link
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
  padding: 5px;
  margin: 5px;
}

.hero-img {
  height: 200px;
  width: 200px;
  margin-right: 400px;
}



</style>