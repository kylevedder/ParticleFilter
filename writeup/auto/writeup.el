(TeX-add-style-hook
 "writeup"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "11pt")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("geometry" "margin=1in")))
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art11"
    "amsmath"
    "amssymb"
    "fancyhdr"
    "geometry"
    "microtype"
    "graphicx"
    "tikz"
    "mathtools"
    "color")
   (TeX-add-symbols
    '("topic" 1)
    "myname"
    "myaddress")
   (LaTeX-add-environments
    "answer")
   (LaTeX-add-mathtools-DeclarePairedDelimiters
    '("ceil" "")))
 :latex)

