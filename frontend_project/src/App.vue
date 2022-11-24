<template>
  <div id="app">
    <HeaderVue></HeaderVue>
    <router-view></router-view>
    <FooterVue></FooterVue>
  </div>
</template>
<script>
import HeaderVue from "@/components/common/HeaderVue";
import FooterVue from "@/components/common/FooterVue";

export default {
  components: {
    HeaderVue,
    FooterVue,
  },
};
</script>

<style>
#app {
  height: 1000px;
  width: 100%;
}

@import "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css";
@import "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css";
@import "https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css";
/*@import "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js";*/

@import "assets/css/common/common.css";
@import "assets/css/common/nav.css";
@import "assets/css/common/footer.css";
@import "assets/css/map.css";

@import "assets/css/transfer/transferAdd.css";

</style>
