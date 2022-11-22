<template>
    <div>
      <div class="form-group col-md-2">
          <select
            class="form-select"
            id="sido"
            v-model="this.$store.state.selectsidoCode"
            @change="gugunList($event)"
          >
            <option
              v-for="(item, index) in this.$store.state.sidos"
              :value="item.value"
              :key="index"
            >
              {{ item.text }}
            </option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select
            class="form-select"
            id="gugun"
            v-model="this.$store.state.selectgugunCode"
            @change="dongList($event)"
          >
            <option
              v-for="(item, index) in this.$store.state.guguns"
              :value="item.value"
              :key="index"
            >
              {{ item.text }}
            </option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select" id="dong" v-model="this.$store.state.selectDongCode" @change="dongChange($event)">
            <option
              v-for="(item, index) in this.$store.state.dongs"
              :value="item.value"
              :key="index"
            >
              {{ item.text }}
            </option>
          </select>
        </div>
    </div>
  </template>
  
  <script>
    import { mapState, mapActions, mapMutations } from "vuex";


  const regionStore = "regionStore";
  export default {
    name: "AddressVue",
      create: {
          ...mapState(regionStore, ["sidos", "guguns", "dongs", "selectsidoName", "selectgugunName", "selectdongName"]),
          ...mapActions(regionStore, ["getSido", "getGugun", "getDong","setSelectDongCode","selectgugunCode","selectsidoCode"]),
          ...mapMutations(regionStore, [
          "CLEAR_SIDO_LIST",
          "CLEAR_GUGUN_LIST",
          "CLEAR_DONG_LIST",
      ]),
      },
      
      computed: {
          
      },
      methods: {
      
      gugunList: function (e) {
        console.log(e.target)
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
      
  }
  </script>
  
  <style>
  
  </style>