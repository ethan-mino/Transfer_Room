<template>
  <div></div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const regionStore = "regionStore";
export default {
  name: "AddressVue",
  create: {
    ...mapState(regionStore, [
      "sidos",
      "guguns",
      "dongs",
      "selectsidoName",
      "selectgugunName",
      "selectdongName",
    ]),
    ...mapActions(regionStore, [
      "getSido",
      "getGugun",
      "getDong",
      "setSelectDongCode",
      "selectgugunCode",
      "selectsidoCode",
    ]),
    ...mapMutations(regionStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
  },

  computed: {},
  methods: {
    gugunList: function (e) {
      console.log(e.target);
      this.CLEAR_GUGUN_LIST();
      this.selectgugunCode = null;
      if (this.selectsidoCode) this.getGugun(this.selectsidoCode);
    },
    dongList: function (e) {
      console.log(e.target);
      this.CLEAR_DONG_LIST();
      this.selectDongCode = null;
      if (this.selectgugunCode) this.getDong(this.selectgugunCode);
    },
    dongChange: function (e) {
      console.log(e.target);
    },
  },
};
</script>

<style></style>
