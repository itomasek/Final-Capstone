<template>
  <div id="app">
    
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


</style>

