! function(u) {
    function c(t, e) {
        if (e = e || {}, (t = t || "") instanceof c) return t;
        if (!(this instanceof c)) return new c(t, e);
        var r, n, a, i, s, o, f, h, l = (n = {
            r: 0,
            g: 0,
            b: 0
        }, o = s = i = null, h = f = !(a = 1), "string" == typeof(r = t) && (r = function(t) {
            t = t.replace(F, "").replace(C, "").toLowerCase();
            var e, r = !1;
            if (j[t]) t = j[t], r = !0;
            else if ("transparent" == t) return {
                r: 0,
                g: 0,
                b: 0,
                a: 0,
                format: "name"
            };
            return (e = P.rgb.exec(t)) ? {
                r: e[1],
                g: e[2],
                b: e[3]
            } : (e = P.rgba.exec(t)) ? {
                r: e[1],
                g: e[2],
                b: e[3],
                a: e[4]
            } : (e = P.hsl.exec(t)) ? {
                h: e[1],
                s: e[2],
                l: e[3]
            } : (e = P.hsla.exec(t)) ? {
                h: e[1],
                s: e[2],
                l: e[3],
                a: e[4]
            } : (e = P.hsv.exec(t)) ? {
                h: e[1],
                s: e[2],
                v: e[3]
            } : (e = P.hsva.exec(t)) ? {
                h: e[1],
                s: e[2],
                v: e[3],
                a: e[4]
            } : (e = P.hex8.exec(t)) ? {
                r: x(e[1]),
                g: x(e[2]),
                b: x(e[3]),
                a: H(e[4]),
                format: r ? "name" : "hex8"
            } : (e = P.hex6.exec(t)) ? {
                r: x(e[1]),
                g: x(e[2]),
                b: x(e[3]),
                format: r ? "name" : "hex"
            } : (e = P.hex4.exec(t)) ? {
                r: x(e[1] + "" + e[1]),
                g: x(e[2] + "" + e[2]),
                b: x(e[3] + "" + e[3]),
                a: H(e[4] + "" + e[4]),
                format: r ? "name" : "hex8"
            } : !!(e = P.hex3.exec(t)) && {
                r: x(e[1] + "" + e[1]),
                g: x(e[2] + "" + e[2]),
                b: x(e[3] + "" + e[3]),
                format: r ? "name" : "hex"
            }
        }(r)), "object" == typeof r && (R(r.r) && R(r.g) && R(r.b) ? (n = function(t, e, r) {
            return {
                r: 255 * y(t, 255),
                g: 255 * y(e, 255),
                b: 255 * y(r, 255)
            }
        }(r.r, r.g, r.b), f = !0, h = "%" === String(r.r).substr(-1) ? "prgb" : "rgb") : R(r.h) && R(r.s) && R(r.v) ? (i = w(r.s), s = w(r.v), n = function(t, e, r) {
            t = 6 * y(t, 360), e = y(e, 100), r = y(r, 100);
            var n = u.floor(t),
                a = t - n,
                i = r * (1 - e),
                s = r * (1 - a * e),
                o = r * (1 - (1 - a) * e),
                f = n % 6;
            return {
                r: 255 * [r, s, i, i, o, r][f],
                g: 255 * [o, r, r, s, i, i][f],
                b: 255 * [i, i, o, r, r, s][f]
            }
        }(r.h, i, s), f = !0, h = "hsv") : R(r.h) && R(r.s) && R(r.l) && (i = w(r.s), o = w(r.l), n = function(t, e, r) {
            function n(t, e, r) {
                return r < 0 && (r += 1), 1 < r && --r, r < 1 / 6 ? t + 6 * (e - t) * r : r < .5 ? e : r < 2 / 3 ? t + 6 * (e - t) * (2 / 3 - r) : t
            }
            var a, i, s, o, f;
            return t = y(t, 360), e = y(e, 100), r = y(r, 100), 0 === e ? a = i = s = r : (a = n(f = 2 * r - (o = r < .5 ? r * (1 + e) : r + e - r * e), o, t + 1 / 3), i = n(f, o, t), s = n(f, o, t - 1 / 3)), {
                r: 255 * a,
                g: 255 * i,
                b: 255 * s
            }
        }(r.h, i, o), f = !0, h = "hsl"), r.hasOwnProperty("a") && (a = r.a)), a = v(a), {
            ok: f,
            format: r.format || h,
            r: I(255, L(n.r, 0)),
            g: I(255, L(n.g, 0)),
            b: I(255, L(n.b, 0)),
            a: a
        });
        this._originalInput = t, this._r = l.r, this._g = l.g, this._b = l.b, this._a = l.a, this._roundA = M(100 * this._a) / 100, this._format = e.format || l.format, this._gradientType = e.gradientType, this._r < 1 && (this._r = M(this._r)), this._g < 1 && (this._g = M(this._g)), this._b < 1 && (this._b = M(this._b)), this._ok = l.ok, this._tc_id = q++
    }

    function a(t, e, r) {
        t = y(t, 255), e = y(e, 255), r = y(r, 255);
        var n, a = L(t, e, r),
            i = I(t, e, r),
            s = (a + i) / 2;
        if (a == i) n = f = 0;
        else {
            var o = a - i,
                f = .5 < s ? o / (2 - a - i) : o / (a + i);
            switch (a) {
                case t:
                    n = (e - r) / o + (e < r ? 6 : 0);
                    break;
                case e:
                    n = (r - t) / o + 2;
                    break;
                case r:
                    n = (t - e) / o + 4
            }
            n /= 6
        }
        return {
            h: n,
            s: f,
            l: s
        }
    }

    function i(t, e, r) {
        t = y(t, 255), e = y(e, 255), r = y(r, 255);
        var n, a = L(t, e, r),
            i = I(t, e, r),
            s = a,
            o = a - i,
            f = 0 === a ? 0 : o / a;
        if (a == i) n = 0;
        else {
            switch (a) {
                case t:
                    n = (e - r) / o + (e < r ? 6 : 0);
                    break;
                case e:
                    n = (r - t) / o + 2;
                    break;
                case r:
                    n = (t - e) / o + 4
            }
            n /= 6
        }
        return {
            h: n,
            s: f,
            v: s
        }
    }

    function e(t, e, r, n) {
        var a = [k(M(t).toString(16)), k(M(e).toString(16)), k(M(r).toString(16))];
        return n && a[0].charAt(0) == a[0].charAt(1) && a[1].charAt(0) == a[1].charAt(1) && a[2].charAt(0) == a[2].charAt(1) ? a[0].charAt(0) + a[1].charAt(0) + a[2].charAt(0) : a.join("")
    }

    function s(t, e, r, n) {
        return [k(S(n)), k(M(t).toString(16)), k(M(e).toString(16)), k(M(r).toString(16))].join("")
    }

    function t(t, e) {
        e = 0 === e ? 0 : e || 10;
        var r = c(t).toHsl();
        return r.s -= e / 100, r.s = A(r.s), c(r)
    }

    function r(t, e) {
        e = 0 === e ? 0 : e || 10;
        var r = c(t).toHsl();
        return r.s += e / 100, r.s = A(r.s), c(r)
    }

    function n(t) {
        return c(t).desaturate(100)
    }

    function o(t, e) {
        e = 0 === e ? 0 : e || 10;
        var r = c(t).toHsl();
        return r.l += e / 100, r.l = A(r.l), c(r)
    }

    function f(t, e) {
        e = 0 === e ? 0 : e || 10;
        var r = c(t).toRgb();
        return r.r = L(0, I(255, r.r - M(-e / 100 * 255))), r.g = L(0, I(255, r.g - M(-e / 100 * 255))), r.b = L(0, I(255, r.b - M(-e / 100 * 255))), c(r)
    }

    function h(t, e) {
        e = 0 === e ? 0 : e || 10;
        var r = c(t).toHsl();
        return r.l -= e / 100, r.l = A(r.l), c(r)
    }

    function l(t, e) {
        var r = c(t).toHsl(),
            n = (r.h + e) % 360;
        return r.h = n < 0 ? 360 + n : n, c(r)
    }

    function g(t) {
        var e = c(t).toHsl();
        return e.h = (e.h + 180) % 360, c(e)
    }

    function b(t) {
        var e = c(t).toHsl(),
            r = e.h;
        return [c(t), c({
            h: (r + 120) % 360,
            s: e.s,
            l: e.l
        }), c({
            h: (r + 240) % 360,
            s: e.s,
            l: e.l
        })]
    }

    function d(t) {
        var e = c(t).toHsl(),
            r = e.h;
        return [c(t), c({
            h: (r + 90) % 360,
            s: e.s,
            l: e.l
        }), c({
            h: (r + 180) % 360,
            s: e.s,
            l: e.l
        }), c({
            h: (r + 270) % 360,
            s: e.s,
            l: e.l
        })]
    }

    function _(t) {
        var e = c(t).toHsl(),
            r = e.h;
        return [c(t), c({
            h: (r + 72) % 360,
            s: e.s,
            l: e.l
        }), c({
            h: (r + 216) % 360,
            s: e.s,
            l: e.l
        })]
    }

    function p(t, e, r) {
        e = e || 6, r = r || 30;
        var n = c(t).toHsl(),
            a = 360 / r,
            i = [c(t)];
        for (n.h = (n.h - (a * e >> 1) + 720) % 360; --e;) n.h = (n.h + a) % 360, i.push(c(n));
        return i
    }

    function m(t, e) {
        e = e || 6;
        for (var r = c(t).toHsv(), n = r.h, a = r.s, i = r.v, s = [], o = 1 / e; e--;) s.push(c({
            h: n,
            s: a,
            v: i
        })), i = (i + o) % 1;
        return s
    }

    function v(t) {
        return t = parseFloat(t), (isNaN(t) || t < 0 || 1 < t) && (t = 1), t
    }

    function y(t, e) {
        var r;
        "string" == typeof(r = t) && -1 != r.indexOf(".") && 1 === parseFloat(r) && (t = "100%");
        var n, a = "string" == typeof(n = t) && -1 != n.indexOf("%");
        return t = I(e, L(0, parseFloat(t))), a && (t = parseInt(t * e, 10) / 100), u.abs(t - e) < 1e-6 ? 1 : t % e / parseFloat(e)
    }

    function A(t) {
        return I(1, L(0, t))
    }

    function x(t) {
        return parseInt(t, 16)
    }

    function k(t) {
        return 1 == t.length ? "0" + t : "" + t
    }

    function w(t) {
        return t <= 1 && (t = 100 * t + "%"), t
    }

    function S(t) {
        return u.round(255 * parseFloat(t)).toString(16)
    }

    function H(t) {
        return x(t) / 255
    }

    function R(t) {
        return P.CSS_UNIT.exec(t)
    }
    var F = /^\s+/,
        C = /\s+$/,
        q = 0,
        M = u.round,
        I = u.min,
        L = u.max,
        N = u.random;
    c.prototype = {
        isDark: function() {
            return this.getBrightness() < 128
        },
        isLight: function() {
            return !this.isDark()
        },
        isValid: function() {
            return this._ok
        },
        getOriginalInput: function() {
            return this._originalInput
        },
        getFormat: function() {
            return this._format
        },
        getAlpha: function() {
            return this._a
        },
        getBrightness: function() {
            var t = this.toRgb();
            return (299 * t.r + 587 * t.g + 114 * t.b) / 1e3
        },
        getLuminance: function() {
            var t = this.toRgb(),
                e = t.r / 255,
                r = t.g / 255,
                n = t.b / 255;
            return .2126 * (e <= .03928 ? e / 12.92 : u.pow((.055 + e) / 1.055, 2.4)) + .7152 * (r <= .03928 ? r / 12.92 : u.pow((.055 + r) / 1.055, 2.4)) + .0722 * (n <= .03928 ? n / 12.92 : u.pow((.055 + n) / 1.055, 2.4))
        },
        setAlpha: function(t) {
            return this._a = v(t), this._roundA = M(100 * this._a) / 100, this
        },
        toHsv: function() {
            var t = i(this._r, this._g, this._b);
            return {
                h: 360 * t.h,
                s: t.s,
                v: t.v,
                a: this._a
            }
        },
        toHsvString: function() {
            var t = i(this._r, this._g, this._b),
                e = M(360 * t.h),
                r = M(100 * t.s),
                n = M(100 * t.v);
            return 1 == this._a ? "hsv(" + e + ", " + r + "%, " + n + "%)" : "hsva(" + e + ", " + r + "%, " + n + "%, " + this._roundA + ")"
        },
        toHsl: function() {
            var t = a(this._r, this._g, this._b);
            return {
                h: 360 * t.h,
                s: t.s,
                l: t.l,
                a: this._a
            }
        },
        toHslString: function() {
            var t = a(this._r, this._g, this._b),
                e = M(360 * t.h),
                r = M(100 * t.s),
                n = M(100 * t.l);
            return 1 == this._a ? "hsl(" + e + ", " + r + "%, " + n + "%)" : "hsla(" + e + ", " + r + "%, " + n + "%, " + this._roundA + ")"
        },
        toHex: function(t) {
            return e(this._r, this._g, this._b, t)
        },
        toHexString: function(t) {
            return "#" + this.toHex(t)
        },
        toHex8: function(t) {
            return e = this._r, r = this._g, n = this._b, a = this._a, i = t, s = [k(M(e).toString(16)), k(M(r).toString(16)), k(M(n).toString(16)), k(S(a))], i && s[0].charAt(0) == s[0].charAt(1) && s[1].charAt(0) == s[1].charAt(1) && s[2].charAt(0) == s[2].charAt(1) && s[3].charAt(0) == s[3].charAt(1) ? s[0].charAt(0) + s[1].charAt(0) + s[2].charAt(0) + s[3].charAt(0) : s.join("");
            var e, r, n, a, i, s
        },
        toHex8String: function(t) {
            return "#" + this.toHex8(t)
        },
        toRgb: function() {
            return {
                r: M(this._r),
                g: M(this._g),
                b: M(this._b),
                a: this._a
            }
        },
        toRgbString: function() {
            return 1 == this._a ? "rgb(" + M(this._r) + ", " + M(this._g) + ", " + M(this._b) + ")" : "rgba(" + M(this._r) + ", " + M(this._g) + ", " + M(this._b) + ", " + this._roundA + ")"
        },
        toPercentageRgb: function() {
            return {
                r: M(100 * y(this._r, 255)) + "%",
                g: M(100 * y(this._g, 255)) + "%",
                b: M(100 * y(this._b, 255)) + "%",
                a: this._a
            }
        },
        toPercentageRgbString: function() {
            return 1 == this._a ? "rgb(" + M(100 * y(this._r, 255)) + "%, " + M(100 * y(this._g, 255)) + "%, " + M(100 * y(this._b, 255)) + "%)" : "rgba(" + M(100 * y(this._r, 255)) + "%, " + M(100 * y(this._g, 255)) + "%, " + M(100 * y(this._b, 255)) + "%, " + this._roundA + ")"
        },
        toName: function() {
            return 0 === this._a ? "transparent" : !(this._a < 1) && O[e(this._r, this._g, this._b, !0)] || !1
        },
        toFilter: function(t) {
            var e, r = "#" + s(this._r, this._g, this._b, this._a),
                n = r,
                a = this._gradientType ? "GradientType = 1, " : "";
            return t && (n = "#" + s((e = c(t))._r, e._g, e._b, e._a)), "progid:DXImageTransform.Microsoft.gradient(" + a + "startColorstr=" + r + ",endColorstr=" + n + ")"
        },
        toString: function(t) {
            var e = !!t;
            t = t || this._format;
            var r = !1,
                n = this._a < 1 && 0 <= this._a;
            return !e && n && ("hex" === t || "hex6" === t || "hex3" === t || "hex4" === t || "hex8" === t || "name" === t) ? "name" === t && 0 === this._a ? this.toName() : this.toRgbString() : ("rgb" === t && (r = this.toRgbString()), "prgb" === t && (r = this.toPercentageRgbString()), "hex" !== t && "hex6" !== t || (r = this.toHexString()), "hex3" === t && (r = this.toHexString(!0)), "hex4" === t && (r = this.toHex8String(!0)), "hex8" === t && (r = this.toHex8String()), "name" === t && (r = this.toName()), "hsl" === t && (r = this.toHslString()), "hsv" === t && (r = this.toHsvString()), r || this.toHexString())
        },
        clone: function() {
            return c(this.toString())
        },
        _applyModification: function(t, e) {
            var r = t.apply(null, [this].concat([].slice.call(e)));
            return this._r = r._r, this._g = r._g, this._b = r._b, this.setAlpha(r._a), this
        },
        lighten: function() {
            return this._applyModification(o, arguments)
        },
        brighten: function() {
            return this._applyModification(f, arguments)
        },
        darken: function() {
            return this._applyModification(h, arguments)
        },
        desaturate: function() {
            return this._applyModification(t, arguments)
        },
        saturate: function() {
            return this._applyModification(r, arguments)
        },
        greyscale: function() {
            return this._applyModification(n, arguments)
        },
        spin: function() {
            return this._applyModification(l, arguments)
        },
        _applyCombination: function(t, e) {
            return t.apply(null, [this].concat([].slice.call(e)))
        },
        analogous: function() {
            return this._applyCombination(p, arguments)
        },
        complement: function() {
            return this._applyCombination(g, arguments)
        },
        monochromatic: function() {
            return this._applyCombination(m, arguments)
        },
        splitcomplement: function() {
            return this._applyCombination(_, arguments)
        },
        triad: function() {
            return this._applyCombination(b, arguments)
        },
        tetrad: function() {
            return this._applyCombination(d, arguments)
        }
    }, c.fromRatio = function(t, e) {
        if ("object" == typeof t) {
            var r = {};
            for (var n in t) t.hasOwnProperty(n) && (r[n] = "a" === n ? t[n] : w(t[n]));
            t = r
        }
        return c(t, e)
    }, c.equals = function(t, e) {
        return !(!t || !e) && c(t).toRgbString() == c(e).toRgbString()
    }, c.random = function() {
        return c.fromRatio({
            r: N(),
            g: N(),
            b: N()
        })
    }, c.mix = function(t, e, r) {
        r = 0 === r ? 0 : r || 50;
        var n = c(t).toRgb(),
            a = c(e).toRgb(),
            i = r / 100;
        return c({
            r: (a.r - n.r) * i + n.r,
            g: (a.g - n.g) * i + n.g,
            b: (a.b - n.b) * i + n.b,
            a: (a.a - n.a) * i + n.a
        })
    }, c.readability = function(t, e) {
        var r = c(t),
            n = c(e);
        return (u.max(r.getLuminance(), n.getLuminance()) + .05) / (u.min(r.getLuminance(), n.getLuminance()) + .05)
    }, c.isReadable = function(t, e, r) {
        var n, a, i, s, o = c.readability(t, e),
            f = !1;
        switch ("AA" !== (i = ((a = (a = r) || {
            level: "AA",
            size: "small"
        }).level || "AA").toUpperCase()) && "AAA" !== i && (i = "AA"), "small" !== (s = (a.size || "small").toLowerCase()) && "large" !== s && (s = "small"), (n = {
            level: i,
            size: s
        }).level + n.size) {
            case "AAsmall":
            case "AAAlarge":
                f = 4.5 <= o;
                break;
            case "AAlarge":
                f = 3 <= o;
                break;
            case "AAAsmall":
                f = 7 <= o
        }
        return f
    }, c.mostReadable = function(t, e, r) {
        for (var n, a = null, i = 0, s = (r = r || {}).includeFallbackColors, o = r.level, f = r.size, h = 0; h < e.length; h++) i < (n = c.readability(t, e[h])) && (i = n, a = c(e[h]));
        return c.isReadable(t, a, {
            level: o,
            size: f
        }) || !s ? a : (r.includeFallbackColors = !1, c.mostReadable(t, ["#fff", "#000"], r))
    };
    var z, E, T, j = c.names = {
            aliceblue: "f0f8ff",
            antiquewhite: "faebd7",
            aqua: "0ff",
            aquamarine: "7fffd4",
            azure: "f0ffff",
            beige: "f5f5dc",
            bisque: "ffe4c4",
            black: "000",
            blanchedalmond: "ffebcd",
            blue: "00f",
            blueviolet: "8a2be2",
            brown: "a52a2a",
            burlywood: "deb887",
            burntsienna: "ea7e5d",
            cadetblue: "5f9ea0",
            chartreuse: "7fff00",
            chocolate: "d2691e",
            coral: "ff7f50",
            cornflowerblue: "6495ed",
            cornsilk: "fff8dc",
            crimson: "dc143c",
            cyan: "0ff",
            darkblue: "00008b",
            darkcyan: "008b8b",
            darkgoldenrod: "b8860b",
            darkgray: "a9a9a9",
            darkgreen: "006400",
            darkgrey: "a9a9a9",
            darkkhaki: "bdb76b",
            darkmagenta: "8b008b",
            darkolivegreen: "556b2f",
            darkorange: "ff8c00",
            darkorchid: "9932cc",
            darkred: "8b0000",
            darksalmon: "e9967a",
            darkseagreen: "8fbc8f",
            darkslateblue: "483d8b",
            darkslategray: "2f4f4f",
            darkslategrey: "2f4f4f",
            darkturquoise: "00ced1",
            darkviolet: "9400d3",
            deeppink: "ff1493",
            deepskyblue: "00bfff",
            dimgray: "696969",
            dimgrey: "696969",
            dodgerblue: "1e90ff",
            firebrick: "b22222",
            floralwhite: "fffaf0",
            forestgreen: "228b22",
            fuchsia: "f0f",
            gainsboro: "dcdcdc",
            ghostwhite: "f8f8ff",
            gold: "ffd700",
            goldenrod: "daa520",
            gray: "808080",
            green: "008000",
            greenyellow: "adff2f",
            grey: "808080",
            honeydew: "f0fff0",
            hotpink: "ff69b4",
            indianred: "cd5c5c",
            indigo: "4b0082",
            ivory: "fffff0",
            khaki: "f0e68c",
            lavender: "e6e6fa",
            lavenderblush: "fff0f5",
            lawngreen: "7cfc00",
            lemonchiffon: "fffacd",
            lightblue: "add8e6",
            lightcoral: "f08080",
            lightcyan: "e0ffff",
            lightgoldenrodyellow: "fafad2",
            lightgray: "d3d3d3",
            lightgreen: "90ee90",
            lightgrey: "d3d3d3",
            lightpink: "ffb6c1",
            lightsalmon: "ffa07a",
            lightseagreen: "20b2aa",
            lightskyblue: "87cefa",
            lightslategray: "789",
            lightslategrey: "789",
            lightsteelblue: "b0c4de",
            lightyellow: "ffffe0",
            lime: "0f0",
            limegreen: "32cd32",
            linen: "faf0e6",
            magenta: "f0f",
            maroon: "800000",
            mediumaquamarine: "66cdaa",
            mediumblue: "0000cd",
            mediumorchid: "ba55d3",
            mediumpurple: "9370db",
            mediumseagreen: "3cb371",
            mediumslateblue: "7b68ee",
            mediumspringgreen: "00fa9a",
            mediumturquoise: "48d1cc",
            mediumvioletred: "c71585",
            midnightblue: "191970",
            mintcream: "f5fffa",
            mistyrose: "ffe4e1",
            moccasin: "ffe4b5",
            navajowhite: "ffdead",
            navy: "000080",
            oldlace: "fdf5e6",
            olive: "808000",
            olivedrab: "6b8e23",
            orange: "ffa500",
            orangered: "ff4500",
            orchid: "da70d6",
            palegoldenrod: "eee8aa",
            palegreen: "98fb98",
            paleturquoise: "afeeee",
            palevioletred: "db7093",
            papayawhip: "ffefd5",
            peachpuff: "ffdab9",
            peru: "cd853f",
            pink: "ffc0cb",
            plum: "dda0dd",
            powderblue: "b0e0e6",
            purple: "800080",
            rebeccapurple: "663399",
            red: "f00",
            rosybrown: "bc8f8f",
            royalblue: "4169e1",
            saddlebrown: "8b4513",
            salmon: "fa8072",
            sandybrown: "f4a460",
            seagreen: "2e8b57",
            seashell: "fff5ee",
            sienna: "a0522d",
            silver: "c0c0c0",
            skyblue: "87ceeb",
            slateblue: "6a5acd",
            slategray: "708090",
            slategrey: "708090",
            snow: "fffafa",
            springgreen: "00ff7f",
            steelblue: "4682b4",
            tan: "d2b48c",
            teal: "008080",
            thistle: "d8bfd8",
            tomato: "ff6347",
            turquoise: "40e0d0",
            violet: "ee82ee",
            wheat: "f5deb3",
            white: "fff",
            whitesmoke: "f5f5f5",
            yellow: "ff0",
            yellowgreen: "9acd32"
        },
        O = c.hexNames = function(t) {
            var e = {};
            for (var r in t) t.hasOwnProperty(r) && (e[t[r]] = r);
            return e
        }(j),
        P = (E = "[\\s|\\(]+(" + (z = "(?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?)") + ")[,|\\s]+(" + z + ")[,|\\s]+(" + z + ")\\s*\\)?", T = "[\\s|\\(]+(" + z + ")[,|\\s]+(" + z + ")[,|\\s]+(" + z + ")[,|\\s]+(" + z + ")\\s*\\)?", {
            CSS_UNIT: new RegExp(z),
            rgb: new RegExp("rgb" + E),
            rgba: new RegExp("rgba" + T),
            hsl: new RegExp("hsl" + E),
            hsla: new RegExp("hsla" + T),
            hsv: new RegExp("hsv" + E),
            hsva: new RegExp("hsva" + T),
            hex3: /^#?([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/,
            hex6: /^#?([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/,
            hex4: /^#?([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/,
            hex8: /^#?([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/
        });
    "undefined" != typeof module && module.exports ? module.exports = c : "function" == typeof define && define.amd ? define(function() {
        return c
    }) : window.tinycolor = c
}(Math);