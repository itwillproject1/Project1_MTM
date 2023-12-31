"use strict";
! function() {
    var e = "zoomto";

    function m(e) {
        return null != e
    }

    function t(e, c) {
        var u = this;

        function d() {
            return d3.select(u.options.element)
        }

        function t(e) {
            if (c.scaleFactor < 0) throw Error("Cannot zoom to a negative scale");
            var t = {
                    x: u.options.element.offsetWidth / 2,
                    y: u.options.element.offsetHeight / 2
                },
                o = {
                    x: t.x,
                    y: t.y
                };
            if (m(c.center.lng) && m(c.center.lng)) {
                var n = u.latLngToXY(c.center.lat, c.center.lng);
                if (null === n) throw new Error("The latitude/longitude coordinates that you tried to use as your center are outside the bounds of your projection (your map).");
                o.x = n[0], o.y = n[1]
            }
            var r, a, i = c.scaleFactor * (u.options.element.clientWidth / d3.select(u.options.element).select("svg").attr("data-width")),
                l = {
                    x: t.x - i * o.x,
                    y: t.y - i * o.y
                },
                s = "translate(" + l.x + "," + l.y + ")" + (r = i, void 0 === a && (a = r), "scale(" + r + "," + a + ")");
            d().selectAll("svg>g").transition().duration(e).attr("transform", s), c.onZoomComplete.call(u, {
                translate: l,
                scale: i
            })
        }
        void 0 === u.resizeScaleFactor && (u.resizeScaleFactor = 1);
        var n = function(e, t) {
            for (var o in e) "object" == typeof e[o] && t[o] ? n(e[o], t[o]) : null == t[o] && (t[o] = e[o]);
            return t
        };
        u.resize = function() {
            this.options.responsive && t(0)
        }.bind(u), c = n({
            scaleFactor: 1,
            center: {
                lat: null,
                lng: null
            },
            transition: {
                duration: 1e3
            },
            onZoomComplete: function() {}
        }, c), t(c.transition.duration)
    }
    if ("object" == typeof exports) {
        var o = new(require("datamaps"))({
            element: document.createElement("div")
        });
        o.addPlugin(e, t), module.exports = t
    } else {
        if (void 0 === window.Datamap) throw new Error("The Datamaps library is required before you can use the zoomto plugin.");
        (o = new window.Datamap({
            element: document.createElement("div")
        })).addPlugin(e, t)
    }
}();