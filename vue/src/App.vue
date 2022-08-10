<template>
  <div id="app">
    <div id="hero-banner">WHY IS THIS HERE</div>
    <app-header />
    <side-bar />
    <router-view />
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";
import SideBar from "./components/SideBar.vue";

export default {
  name: "app",
  components: { AppHeader, SideBar },
};
</script>

<style>
#hero-banner {
  background-color: #F6FBFF;
  display: flex;
  height: 50px;
}

</style>

