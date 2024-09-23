
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReserveReserveManager from "./components/listers/ReserveReserveCards"
import ReserveReserveDetail from "./components/listers/ReserveReserveDetail"

import TicketTicketManager from "./components/listers/TicketTicketCards"
import TicketTicketDetail from "./components/listers/TicketTicketDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reserves/reserves',
                name: 'ReserveReserveManager',
                component: ReserveReserveManager
            },
            {
                path: '/reserves/reserves/:id',
                name: 'ReserveReserveDetail',
                component: ReserveReserveDetail
            },

            {
                path: '/tickets/tickets',
                name: 'TicketTicketManager',
                component: TicketTicketManager
            },
            {
                path: '/tickets/tickets/:id',
                name: 'TicketTicketDetail',
                component: TicketTicketDetail
            },



    ]
})
