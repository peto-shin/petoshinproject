
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SeatselectionSeatSelectionManager from "./components/listers/SeatselectionSeatSelectionCards"
import SeatselectionSeatSelectionDetail from "./components/listers/SeatselectionSeatSelectionDetail"

import SeatSeatManager from "./components/listers/SeatSeatCards"
import SeatSeatDetail from "./components/listers/SeatSeatDetail"

import ReservationReservationManager from "./components/listers/ReservationReservationCards"
import ReservationReservationDetail from "./components/listers/ReservationReservationDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/seatselections/seatSelections',
                name: 'SeatselectionSeatSelectionManager',
                component: SeatselectionSeatSelectionManager
            },
            {
                path: '/seatselections/seatSelections/:id',
                name: 'SeatselectionSeatSelectionDetail',
                component: SeatselectionSeatSelectionDetail
            },

            {
                path: '/seats/seats',
                name: 'SeatSeatManager',
                component: SeatSeatManager
            },
            {
                path: '/seats/seats/:id',
                name: 'SeatSeatDetail',
                component: SeatSeatDetail
            },

            {
                path: '/reservations/reservations',
                name: 'ReservationReservationManager',
                component: ReservationReservationManager
            },
            {
                path: '/reservations/reservations/:id',
                name: 'ReservationReservationDetail',
                component: ReservationReservationDetail
            },




    ]
})
