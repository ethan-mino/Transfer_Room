<template>
  <div class="not-main">
    <HeaderVue></HeaderVue>
    <SignupVue></SignupVue>
  </div>
  
</template>

<script>
import SignupVue from "@/components/user/SignupVue";
import HeaderVue from "@/components/common/HeaderVue";

export default {
  name: "SignupView",
  components: {
    SignupVue,
    HeaderVue,
  },
};
</script>

<style>
</style>
