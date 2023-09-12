<template>
  <div id="app">
    <navMenu></navMenu>
    <router-view></router-view>
  </div>
</template>


<script>

import navMenu from './components/navMenu.vue';
export default {
  name: 'App',
  components: {
    navMenu
  },
  data() {
    return {}
  }
}
</script>


<style>
/* #app {
  background: url("./assets/luffy.png") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
} */

</style>
