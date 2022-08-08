<template>
  <div>
      <h1>This is all of your cards</h1>
      <card-list/>
  </div>
</template>

<script>
import CardList from '../components/CardList.vue'
export default {
  components: { CardList },
  name: "all-cards",

}
</script>

<style>

</style>